package com.example.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemoController {

    @Autowired
    private MemoService memoService;

    //주소로 직접이동하는경우
    @GetMapping("/save")
    public String getForm(){
        return "memoForm";
        //templates 밑에 memoForm.html로 이동함.
    }

    // save를 post로 입력한 경우
    @PostMapping("/save")
    public String saveData(@ModelAttribute Memo memo, Model model){
        //getParameter 대신 @modelAttribute 어노테이션을 통해 memo 객체로 자동으로 받아옴.
        System.out.println("memo객체:" + memo);
        model.addAttribute("result", memoService.saveMemo(memo));
        return "result";
    }


}
