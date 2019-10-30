/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.dashboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author marcelo
 */
@Controller
public class DashboardController {
    
    private static final String NOT_FOUND_IMG = ""; 
    private static final String UPLOADED_FOLDER = "c:/Users/Marcelo/Pictures/"; 

    @GetMapping("dashboard/list")
    public String dashboard(Model model) throws IOException {

        model.addAttribute("msg", "SGH Dashboard");
        
        File file = new File(UPLOADED_FOLDER + "img.png");
        
        if(file.exists()){
            
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            
            String encodeString = Base64.getEncoder().encodeToString(fileContent);
            
            model.addAttribute("base64Image", encodeString);
        }else{
            
            model.addAttribute("base64Image", NOT_FOUND_IMG);
        }
        

        return "dashboard";

    }
    
    @PostMapping("dashboard/upload")
    public String dashboardUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        
        if(!file.isEmpty()){
            
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + "img.png");
                Files.write(path,bytes);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return "redirect:/dashboard/list";
        }
        
        return "redirect:/error";
    }
}
