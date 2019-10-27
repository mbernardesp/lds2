/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.dashboard;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class DashboardController {

    @GetMapping("dashboard/list")
    public String dashboard(Model model) throws IOException {

        model.addAttribute("msg", "SGH Dashboard");

        return "dashboard";

    }
}
