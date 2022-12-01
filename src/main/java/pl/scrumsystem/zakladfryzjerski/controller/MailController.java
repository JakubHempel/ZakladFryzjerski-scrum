package pl.scrumsystem.zakladfryzjerski.controller;

import org.springframework.web.bind.annotation.PostMapping;
import pl.scrumsystem.zakladfryzjerski.service.EmailService;

public class MailController
{
    private EmailService emailService;

    public MailController(EmailService emailService)
    {
        this.emailService = emailService;
    }

}
