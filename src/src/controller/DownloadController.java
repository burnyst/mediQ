package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;
import dbcp.JdbcUtil;
import model.Qnamodel;

public class DownloadController implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Download controller호출성공");
		req.setCharacterEncoding("UTF-8");
		 int sn= Integer.parseInt(req.getParameter("sn"));
		Connection conn = null;
		 conn  = JdbcUtil.getConnection();
		 //※쿼리...
		 Qnamodel qm = QnaDAO.selectById(conn,sn);

	        // 파일 이름을 받아서
	        String  image = qm.getImage();
	        System.out.println("image이름=>"+image);

	        // 실제 파일이 들어있는 경로에 설정한 
	        // upload폴더와 파일 이름을 붙여서
	        //String uploadFileName = req.getRealPath("/upload") + "/" + image;
	        String uploadFileName = req.getSession().getServletContext().getRealPath("/upload")+ "/" + image;
	       System.out.println("uploadFileName = "+uploadFileName);

	        // 해당 스트링에서 파일을 가져온 후
	        File downFile = new File(uploadFileName);
	 
	        // 다운로드
	        if (downFile.exists() && downFile.isFile()) {
	 
	            try {
	                // 파일 사이즈 조사하고
	                long filesize = downFile.length();

	                // content타입과 해더를 셋팅하여 파일을 출력
	                res.setContentType("application/x-msdownload");
	                res.setContentLength((int) filesize);
	                String strClient = req.getHeader("user-agent");
	 
	                if (strClient.indexOf("MSIE 5.5") != -1) {
	                    res.setHeader("Content-Disposition", "image="
	                            + image + ";");
	                } else {
	                    res.setHeader("Content-Disposition",
	                            "attachment; image=" + image+ ";");
	                }
	                res.setHeader("Content-Length", String.valueOf(filesize));
	                res.setHeader("Content-Transfer-Encoding", "binary;");
	                res.setHeader("Pragma", "no-cache");
	                res.setHeader("Cache-Control", "private");
	 
	                byte b[] = new byte[1024];
	 
	                BufferedInputStream fin = new BufferedInputStream(
	                        new FileInputStream(downFile));
	 
	                BufferedOutputStream outs = new BufferedOutputStream(
	                        res.getOutputStream());
	 
	                int read = 0;
	 
	                while ((read = fin.read(b)) != -1) {
	                    outs.write(b, 0, read);
	                }
	                outs.flush();
	                outs.close();
	                fin.close();
	            } catch (Exception e) {
	                System.out.println("Download Exception : " + e.getMessage());
	            }
	        } else {
	            System.out.println("Download Error : downFile Error [" + downFile
	                    + "]");
	        }
		return null;
	}

}
