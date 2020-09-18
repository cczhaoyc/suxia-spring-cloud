package com.suxia.ysyc.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSON;
import com.suxia.ysyc.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 * 邮件配置
 * </p>
 *
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date 2020/9/10 15:21
 */
public class EmailUtil {

    private static final Logger LOG = LoggerFactory.getLogger(EmailUtil.class);

    /**
     * <p>
     * 发送邮件
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/9/10 17:21
     */
    public static boolean sendEmail(MailBody mailBody) {
        String host = mailBody.getHost();
        String port = mailBody.getPort();
        String from = mailBody.getFrom();
        String pass = mailBody.getPass();
        String fromName = mailBody.getFromName();
        String subject = mailBody.getSubject();
        String content = mailBody.getContent();
        List<String> tos = mailBody.getTos();
        if (IterUtil.isEmpty(tos)) {
            throw new BusinessException("收件人列表不能为空");
        }
        List<String> ccs = mailBody.getCcs();
        List<String> attaches = mailBody.getAttaches();

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // 设置邮件会话参数
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", port);
        if (!"25".equals(port)) {
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", port);
        }
        props.put("mail.smtp.auth", "true");
        // 发件人邮箱用户名
        final String username = from;
        // 发件人邮箱密码
        final String password = pass;
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message msg = new MimeMessage(session);
            // 设置发件人名称
            String fromNick;
            try {
                fromNick = MimeUtility.encodeText(fromName);
            } catch (UnsupportedEncodingException e) {
                fromNick = from;
            }
            // 设置发件人
            msg.setFrom(new InternetAddress(fromNick + "<" + from + ">"));
            // 设置收件人
            Address[] to = new InternetAddress[tos.size()];
            for (int i = 0; i < tos.size(); i++) {
                to[i] = new InternetAddress(tos.get(i));
            }
            // 设置收件人
            msg.setRecipients(Message.RecipientType.TO, to);
            if (IterUtil.isNotEmpty(ccs)) {
                // 设置抄送人
                Address[] cc = new InternetAddress[ccs.size()];
                for (int i = 0; i < ccs.size(); i++) {
                    cc[i] = new InternetAddress(ccs.get(i));
                    i++;
                }
                // 设置抄送人
                msg.setRecipients(Message.RecipientType.CC, cc);
            }
            // 设置邮件主题
            msg.setSubject(subject);
            // 设置邮件内容
            MimeMultipart multi = new MimeMultipart();
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(content, "text/html;charset=UTF-8");
            multi.addBodyPart(textBodyPart);
            // 设置附件
            if (IterUtil.isNotEmpty(attaches)) {
                for (String attache : attaches) {
                    MimeBodyPart bodyPart = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(attache); // 文件数据源
                    bodyPart.setDataHandler(new DataHandler(fds)); // 将附件并放入BodyPart
                    try {
                        // 得到文件名并编码（防止中文文件名乱码）同样放入BodyPart
                        bodyPart.setFileName(MimeUtility.encodeText(fds.getName()));
                    } catch (UnsupportedEncodingException e) {
                        bodyPart.setFileName(fds.getName());
                    }
                    multi.addBodyPart(bodyPart);
                }
            }
            // 此方法将给定的Multipart对象设置为此消息的内容
            msg.setContent(multi);
            // 设置发送时间
            msg.setSentDate(new Date());
            // 保存更改
            msg.saveChanges();
            // 发送消息
            Transport.send(msg);
        } catch (MessagingException e) {
            LOG.warn("邮件发送失败,收件人列表=[{}],邮件内容={}", JSON.toJSON(tos), content, e);
            return false;
        }
        return true;
    }

    public static String sendEmailByHuTool(MailAccount mailAccount, Collection<String> tos, String subject, String content) {
        return MailUtil.send(mailAccount, tos, subject, content, false);
    }

    /**
     * <p>
     * 邮件正文
     * </p>
     *
     * @author cczhaoyc@163.com
     * @date 2020/9/10 17:23
     */
    public static class MailBody {

        /**
         * SMTP服务器域名
         */
        private String host;

        /**
         * SMTP服务端口
         */
        private String port;

        /**
         * 发件人邮箱
         */
        private String from;

        /**
         * 发件人邮箱密码或授权码
         */
        private String pass;

        /**
         * 发件人名称
         */
        private String fromName;

        /**
         * 邮件主题
         */
        private String subject;

        /**
         * 邮件内容
         */
        private String content;

        /**
         * 收件人列表
         */
        private List<String> tos;

        /**
         * 抄送人列表
         */
        private List<String> ccs;

        /**
         * 附件列表
         */
        private List<String> attaches;


        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }


        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getFromName() {
            return fromName;
        }

        public void setFromName(String fromName) {
            this.fromName = fromName;
        }

        public List<String> getTos() {
            return tos;
        }

        public void setTos(List<String> tos) {
            this.tos = tos;
        }

        public List<String> getCcs() {
            return ccs;
        }

        public void setCcs(List<String> ccs) {
            this.ccs = ccs;
        }

        public List<String> getAttaches() {
            return attaches;
        }

        public void setAttaches(List<String> attaches) {
            this.attaches = attaches;
        }
    }

    public static void main(String[] args) {
        MailBody msg = new MailBody();
        msg.setHost("smtp.163.com");
        msg.setPort("25");
        msg.setFrom("xxx@163.com");
        msg.setPass("xxx");
        msg.setFromName("苏夏未来-云舞之森(系统邮件)");
        msg.setSubject("苏夏未来-云舞之森(系统邮件)");
        msg.setContent("苏夏未来-云舞之森(系统邮件)");
        msg.setAttaches(CollUtil.newArrayList("C:/Users/jiayunsen/Desktop/MyFiles/Linux常用指令.txt"));
        msg.setTos(CollUtil.newArrayList("xxx@163.com"));
        msg.setCcs(CollUtil.newArrayList("xxx@qq.com"));
        /*boolean send = sendEmail(msg);
        if (send) {
            System.out.println("邮件发送成功");
        }*/

        MailAccount account = new MailAccount();
        account.setHost("smtp.163.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("xxx@163.com");
        account.setUser("xxx@163.com");
        //密码(注意不是登录密码，是网易客户端登录授权码)
        account.setPass("xxx");
        String result = sendEmailByHuTool(account, CollUtil.newArrayList("xxx@163.com"), "测试", "xxx");
        if (StringUtils.isNotBlank(result)) {
            System.out.println("邮件发送成功:" + result);
        }

    }
}
