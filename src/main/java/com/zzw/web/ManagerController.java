package com.zzw.web;

import com.zzw.dto.JsonResult;
import com.zzw.entity.Borrower;
import com.zzw.entity.custom.BorrowerCustom;
import com.zzw.entity.custom.LoanCustom;
import com.zzw.service.BorrowerService;
import com.zzw.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/mgr")
public class ManagerController {

    @Autowired
    BorrowerService borrowerService;

    @Autowired
    ItemService itemService;

    @RequestMapping("")
    public String index() {
        return "redirect:/mgr/loanview";
    }

    @RequestMapping("/loanview")
    public String loanView() {
        return "mgr/loanview";
    }

    @RequestMapping(value = "/{cardno}/loanview2")
    public String loanview2(Model model, @PathVariable("cardno") String cardno) throws Exception {
        BorrowerCustom borrowerCustom = itemService.findBorrowerWithLoanList(cardno);
        model.addAttribute("cardno", cardno);
        model.addAttribute("borrowerCustom", borrowerCustom);
        return "mgr/loanview2";
    }

    @RequestMapping(value = "/returnitem", method = RequestMethod.POST)
    public String returnitem(HttpServletRequest request, Model model) {
        String cardno = request.getParameter("cardno");
        String libraryCode = request.getParameter("librarycode");
        try {
            itemService.returnItem(libraryCode, cardno);
            model.addAttribute("result", "物品" + libraryCode + "归还成功！");
        } catch (Exception e) {
            model.addAttribute("error_msg", e.getMessage());
        }

        return "mgr/returnview";
    }

    @RequestMapping(value = "/loanitem", method = {RequestMethod.POST})
    @ResponseBody
    public JsonResult<?> loanitem(HttpServletRequest request) {
        String cardno = request.getParameter("cardno");
        String libraryCode = request.getParameter("librarycode");
        JsonResult<?> res = new JsonResult<>();
        try {
            itemService.loanItem(libraryCode, cardno);
            res.setErr_code(0);
            res.setErr_msg("succeed");
        } catch (Exception e) {
            res.setErr_code(1);
            res.setErr_msg(e.getMessage());
        }
        return res;
    }


    /**
     * 验证借阅号接口
     *
     * @param request 请求对象
     * @return json包装
     */
    @RequestMapping(value = "/vrfyusr", method = {RequestMethod.POST})
    @ResponseBody
    public JsonResult<Borrower> verifyUser(HttpServletRequest request) {
        String cardno = request.getParameter("cardno");
        JsonResult<Borrower> res;
        try {
            Borrower borrower = borrowerService.findBorrowerByCardno(cardno);
            res = new JsonResult<>(0, borrower);
        } catch (Exception e) {
            res = new JsonResult<>(1, e.getMessage());
        }
        return res;
    }


}
