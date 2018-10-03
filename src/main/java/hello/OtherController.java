package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class OtherController {
    private SimpMessagingTemplate template;

    public OtherController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/other")
    public void other() {
        template.convertAndSend("/topic/greetings", new Greeting("Hello, " + HtmlUtils.htmlEscape("OtherOther!")));
    }
}
