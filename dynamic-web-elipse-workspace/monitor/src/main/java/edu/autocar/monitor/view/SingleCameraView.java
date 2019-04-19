package edu.autocar.monitor.view;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.autocar.monitor.service.MjpegBroker;

@Component("camera")
@Scope("request") // request별로
public class SingleCameraView extends MjpegView implements Observer {
	@Autowired
	MjpegBroker broker;
	
	BlockingQueue<byte[]> queue = new LinkedBlockingQueue<>(5);
	int deviceId;

	@Override
	protected void init(Map<String, Object> model, HttpServletResponse response) throws Exception {
		super.init(model, response);
		deviceId = (int) model.get("deviceId");
		System.out.println(deviceId + " " + this.hashCode());
		broker.addObserver(deviceId, this);
	}

	@Override
	public void update(Observable o, Object image) {
		try {
			queue.put((byte[]) image);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected byte[] getImage() throws Exception {
		System.out.println(queue);
		return queue.take();
	}

	@Override
	protected void cleanup() throws Exception {
		super.cleanup();
		queue.clear();
		broker.deleteObserver(deviceId, this);
	}

}

/*
 * @Component("camera")
 * 
 * @Scope("request") //request별로 public class SingleCameraView extends MjpegView
 * implements Observer {
 * 
 * @Autowired JpgImageSource source; BlockingQueue<byte[]> queue = new
 * LinkedBlockingQueue<>(5);
 * 
 * @Override protected void init(Map<String, Object> model, HttpServletResponse
 * response) throws Exception { System.out.println("=="); super.init(model,
 * response); source.addObserver(this); }
 * 
 * @Override protected byte[] getImage() throws Exception { return queue.take();
 * }
 * 
 * @Override public void update(Observable o, Object image) { try {
 * queue.put((byte[]) image); } catch (InterruptedException e) {
 * e.printStackTrace(); } }
 * 
 * @Override protected void cleanup() throws Exception { // TODO Auto-generated
 * method stub super.cleanup(); queue.clear(); }
 * 
 * }
 */
