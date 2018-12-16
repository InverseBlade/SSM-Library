package com.zzw.web;

import com.zzw.dto.JsonResult;
import com.zzw.entity.Borrower;
import com.zzw.entity.Loan;
import com.zzw.entity.Title;
import com.zzw.entity.custom.BorrowerCustom;
import com.zzw.entity.custom.LoanAffirmInfo;
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

@Controller
@RequestMapping(value = "/mgr")
public class ManagerController {

    @Autowired
    BorrowerService borrowerService;

    @Autowired
    ItemService itemService;

    /**
     * 管理员主页
     *
     * @return
     */
    @RequestMapping("")
    public String index() {
        return "mgr/home";
    }

    /**
     * 验证借阅证页面
     *
     * @param action
     * @param model
     * @return
     */
    @RequestMapping("/{action}/checkcardno")
    public String checkCardno(@PathVariable("action") String action,
                              Model model) {
        if (action == null) {
            return "redirect:/mgr";
        }
        String targetUrl;
        switch (action.toLowerCase()) {
            case "return":
                targetUrl = "/mgr/returnview";
                break;
            case "loan":
                targetUrl = "/mgr/loanview";
                break;
            default:
                targetUrl = "/mgr";
        }
        model.addAttribute("targetUrl", targetUrl);
        return "mgr/page-check-cardno";
    }

    /**
     * 归还物品页面
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/returnview", method = RequestMethod.GET)
    public String returnView(Model model) throws Exception {

        return "mgr/page-returnitem";
    }

    /**
     * 借出物品页面
     *
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loanview")
    public String loanView(Model model,
                           HttpServletRequest request) throws Exception {
        String cardno = (String) request.getParameter("cardno");
        BorrowerCustom borrowerCustom = itemService.findBorrowerWithLoanList(cardno);
        model.addAttribute("cardno", cardno);
        model.addAttribute("borrowerCustom", borrowerCustom);
        return "mgr/page-loanitem";
    }

    /**
     * 归还物品表单处理
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/returnitem", method = RequestMethod.POST)
    public String returnItem(HttpServletRequest request, Model model) {
        String cardno = request.getParameter("cardno");
        String libraryCode = request.getParameter("librarycode");
        try {
            itemService.returnItem(libraryCode);
            model.addAttribute("result", "物品:" + libraryCode + "归还成功！");
            model.addAttribute("error_msg", "");
        } catch (Exception e) {
            model.addAttribute("result", "物品:" + libraryCode + "归还失败！");
            model.addAttribute("error_msg", e.getMessage());
        }
        model.addAttribute("title", "还书结果页面");
        return "mgr/page-result";
    }

    /**
     * 借阅物品表单处理
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loanitem", method = RequestMethod.POST)
    public String loanItem(HttpServletRequest request, Model model) throws Exception {
        String cardno = (String) request.getParameter("cardno");
        String libraryCode = (String) request.getParameter("librarycode");
        try {
            itemService.loanItem(libraryCode, cardno);
            model.addAttribute("result", "物品: " + libraryCode + "借阅成功！");
        } catch (Exception e) {
            model.addAttribute("result", "物品：" + libraryCode + "借阅失败！");
            model.addAttribute("error_msg", e.getMessage());
        }
        return "mgr/page-result";
    }

    @RequestMapping(value = "/loanaffirminfo", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<LoanAffirmInfo> apiGetLoanAffirmInfo(HttpServletRequest request) {
        String libraryCode = (String) request.getParameter("librarycode");
        try {
            LoanAffirmInfo loanAffirmInfo = itemService.getLoanAffirmInfo(libraryCode);
            return new JsonResult<>(0, loanAffirmInfo);
        } catch (Exception e) {
            return new JsonResult<>(1, e.getMessage());
        }
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
