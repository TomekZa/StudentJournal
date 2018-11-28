package pl.StudentJournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BeginController {

    private final String REQUEST_BEGIN = "/";
    private final String VIEW_BEGIN_PAGE = "index";

    @RequestMapping(value = REQUEST_BEGIN, method = RequestMethod.GET)

    public String schowBeginPage() {
        return VIEW_BEGIN_PAGE;
    }

}
