package com.demo;

import com.demo.common.Assist;
import com.demo.constant.Types;
import com.demo.constant.WebConst;
import com.demo.utils.AppReponseJsonUtils;
import com.demo.utils.StringUtil;
import com.demo.utils.TaleUtils;
import com.demo.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class Controller {
   public static final String CLASSPATH = TaleUtils.getUplodFilePath();
    @Value("${web.upload-path}")
    private String path;
//    @Value("${httplocation.url}")
//    private String httppath;
    /**
     * erreur de l'utilisateur
     */
    @PostMapping(value = "/fault")
    public Map fault() {
        Map map=new HashMap();
        return AppReponseJsonUtils.setFailSession(map,"该用户已在其他设备上面登录，请重新登录");

    }
    /**
     * L'adresse ou le paramètre de la requête est incorrect
     */
    @GetMapping(value = "/faultservice")
    public Map faultService() {
        Map map=new HashMap();
        return AppReponseJsonUtils.setFail(map,"L'adresse ou le paramètre de la requête est incorrect");

    }
    /**
     * Interface de téléchargement de fichiers
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public Map upload(@RequestParam String userNM,HttpServletRequest request, @RequestParam("file") MultipartFile[] multipartFiles) throws IOException {
        Map map=new HashMap();
        StringBuffer sb=new StringBuffer();
        String voicePath="";
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String fname = multipartFile.getOriginalFilename();
                if (multipartFile.getSize() <= WebConst.MAX_FILE_SIZE) {
                    String fkey = StringUtil.getFileName(fname);
//                    String fkey = UUIDGenerator.getUUID();

                    File file =new File(path+userNM+"/");
                    if (!file.exists()){
                        file.mkdirs();
                    }
                    File file1 = new File(path+userNM+"/"+ fkey);

                    try {
                        FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    String ftype = TaleUtils.isImage(multipartFile.getInputStream()) ? Types.IMAGE.getType() : Types.MP3.getType();
                    if (Types.IMAGE.getType().equals(ftype)){
                        voicePath=userNM+"/" + fkey;
                    }else{
                        voicePath=userNM+"/" + fkey;
                    }

                } else {
                }
            }
        } catch (Exception e) {

            return AppReponseJsonUtils.setFail(map,"le téléchargement a échoué");
        }
        map.put("filepath",voicePath);
        return AppReponseJsonUtils.setMessage(map,"Importé avec succès");
    }
}
