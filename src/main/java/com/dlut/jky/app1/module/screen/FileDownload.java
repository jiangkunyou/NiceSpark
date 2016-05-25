package com.dlut.jky.app1.module.screen;

import com.alibaba.citrus.turbine.TurbineRunData;
import com.dlut.jky.app1.utils.FileUploadManager;
import com.dlut.jky.app1.utils.SSHHelper;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiangkunyou on 15/11/30.
 */
public class FileDownload {

    @Autowired
    private HttpServletResponse response;

    public void execute(TurbineRunData runData) throws IOException {
        doDownload();
    }

    // 获取要下载文件的输入流, 然后读取并输出
    private void doDownload() throws IOException {
        response.setContentType("application/x-msdownload");
        //
        String fileName = "output_file.txt";
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        OutputStream os = response.getOutputStream();
        String filePath = FileUploadManager.getInstance().getLogPath() + "/log";
        FileInputStream fin = new FileInputStream(filePath);
        byte [] buf = new byte[1024];
        int len = 0;
        while((len = fin.read(buf)) != -1){
            os.write(buf, 0, 1024);
        }
        fin.close();
    }

}
