package com.mvp.server.upload;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside doPost");

		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
		// Create a new file upload handler
		ServletFileUpload fileUpload = new ServletFileUpload(factory);

		// sizeMax - The maximum allowed size, in bytes. The default value of -1
		// indicates, that there is no limit.
		// 1048576 bytes = 1024 Kilobytes = 1 Megabyte
		fileUpload.setSizeMax(1048576);

		if (!ServletFileUpload.isMultipartContent(request)) {
			try {

				throw new FileUploadException("error multipart request not found");
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Before try");
		try {

			List<FileItem> items = fileUpload.parseRequest(request);

			if (items == null) {
				System.out.println("items is null");
				response.getWriter().write("File not correctly uploaded");
				return;
			}

			Iterator<FileItem> iter = items.iterator();
			System.out.println("Avant while");
			while (iter.hasNext()) {
				System.out.println("Dans while");
				FileItem item = (FileItem) iter.next();

				////////////////////////////////////////////////
				// http://commons.apache.org/fileupload/using.html
				////////////////////////////////////////////////

				// if (item.isFormField()) {
				String fileName = item.getName();
				System.out.println("fileName is : " + fileName);
				String typeMime = item.getContentType();
				System.out.println("typeMime is : " + typeMime);
				int sizeInBytes = (int) item.getSize();
				System.out.println("Size in bytes is : " + sizeInBytes);
				int i;
				char c;
				InputStream file = item.getInputStream();
				while ((i = file.read()) != -1) {
					// converts integer to character
					c = (char) i;

					// prints character
					System.out.print(c);
				}

				String fileName2 = request.getRealPath("") + "/FilesUploaded/" + item.getName();
				OutputStream outputStream = new FileOutputStream(fileName2);
				InputStream inputStream = item.getInputStream();

				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				if (item.getName() != null) {
					System.out.println("<td><img width='100' heigth='100' src=" + request.getContextPath() + "/images/"
							+ item.getName() + "></td>");
				}
			}

			PrintWriter out = response.getWriter();
			response.setHeader("Content-Type", "text/html");
			out.println("Upload OK");
			out.flush();
			out.close();

		} catch (SizeLimitExceededException e) {
			System.out.println("File size exceeds the limit : 1 MB!!");
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			response.setHeader("Content-Type", "text/html");
			out.println("Error");
			out.flush();
			out.close();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
