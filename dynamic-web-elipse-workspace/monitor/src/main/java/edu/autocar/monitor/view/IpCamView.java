package edu.autocar.monitor.view;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ipcam")
@Scope("request")
public class IpCamView extends MjpegView {
	private InputStream httpIn;
	private ByteArrayOutputStream jpgOut;
	String ipCamUrl = "http://70.12.247.29:4747/video";

// 웹 캠 접속
	@Override
	protected void init(Map<String, Object> model, HttpServletResponse response) throws Exception {
		super.init(model, response);
		URL url = new URL(ipCamUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		httpIn = new BufferedInputStream(conn.getInputStream(), 8192);
	}

	@Override
	public byte[] getImage() throws Exception {
		int prev = 0;
		int cur = 0;
		jpgOut = new ByteArrayOutputStream();
		while ((cur = httpIn.read()) >= 0) {
			// 새로운 프레임 시작
			if (prev == 0xFF && cur == 0xD8) { // jpeg의 시작을 나타낸다.
				jpgOut = new ByteArrayOutputStream();
				jpgOut.write((byte) prev);
			}
			// 수신 데이터 데이터 수신
			if(jpgOut!=null) jpgOut.write((byte)cur);
			
			// 한 프레임 수신 완료
			if (prev == 0xFF && cur == 0xD9) {
				byte[] data = jpgOut.toByteArray();
				jpgOut.reset();
				return data;
			}
			prev = cur;
		}
		return null;
	}

	@Override
	protected void cleanup() throws Exception {
		super.cleanup();
		httpIn.close();
	}

}