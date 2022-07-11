package br.com.dbc.vemser.pessoaapi.service;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {
    private final freemarker.template.Configuration fmConfiguration;
    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    public void sendEmailPessoaCadastrada(PessoaDTO pessoa){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(pessoa.getEmail());
        message.setSubject("Cadastro");
        message.setText("Olá, "+pessoa.getNome()+
                "\nEstamos felizes em ter você em nosso sistema!\n"+
                "Seus cadastro foi realizado com sucesso, sei id é: "+pessoa.getIdPessoa()+
                "\nQualquer dúvida nos contate pelo email "+from);

        emailSender.send(message);
    }

    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Assunto 3");
            mimeMessageHelper.setText(geContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String geContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "MeuNome");
        dados.put("email", "aaa@aaa");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
