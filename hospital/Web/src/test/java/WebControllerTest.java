import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import com.system.controller.WebController;
import com.system.model.Doctor;
import com.system.responseModel.Response;

public class WebControllerTest {

	@Autowired
	WebController controller;

	@Test
	public void test() {
		Doctor d = new Doctor(4L, "JDks", "DShkj");
		Response<Object> data = controller.addDoctor(d);
		System.out.println(data);
	}

}
