
 import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class InfoProcessorTest {
	
	ArrayList<String> lines1 = new ArrayList<String>();
	ArrayList<String> lines2 = new ArrayList<String>();
	ArrayList<String> lines4 = new ArrayList<String>();
	ArrayList<String> lines5 = new ArrayList<String>();
	
	InfoProcessor infoProcessor1 = new InfoProcessor(lines1);  // sample file
	InfoProcessor infoProcessor2 = new InfoProcessor(lines2);  // normal file
	InfoProcessor infoProcessor4 = new InfoProcessor(lines4);  // file with different info
	InfoProcessor infoProcessor5 = new InfoProcessor(lines5);  // another file with different info

	@BeforeEach
	void setUp() throws Exception {
		// sample file
				this.lines1.add("hello");
				this.lines1.add("world");
				this.lines1.add("MCIT");
				
				// normal file
				this.lines2.add("Course:");
				this.lines2.add("CIT590");
				this.lines2.add("CourseID:");
				this.lines2.add("590");
				this.lines2.add("StudentID:");
				this.lines2.add("101");

				// file with different info
				this.lines4.add("Course:");
				this.lines4.add("CIT 593");
				this.lines4.add("CourseID:");
				this.lines4.add("593");
				this.lines4.add("StudentID:");
				this.lines4.add("59876");
				
				// another file with different info
				this.lines5.add("Course:");
				this.lines5.add("OMCIT 596");
				this.lines5.add("CourseID:");
				this.lines5.add("596");
				this.lines5.add("StudentID:");
				this.lines5.add("01");
	}

	@Test
	void testGetCourseName() {
		String actual = infoProcessor2.getCourseName();
		assertEquals("CIT590", actual);
	}

	@Test
	void testGetCourseId() {
		// test normal file
				int actual = infoProcessor2.getCourseId();
				assertEquals(590, actual);
	}

	@Test
	void testGetStudentId() {
		// test normal file
				int actual = infoProcessor2.getStudentId();
				assertEquals(101, actual);
	}

	@Test
	void testGetNextStringStartsWith() {
		// basic functionality test - should return next string in the list
				String actual = infoProcessor1.getNextStringStartsWith("hello");
				assertEquals("world", actual);
				actual = infoProcessor1.getNextStringStartsWith("world");
				assertEquals("MCIT", actual);
				
				//test for string that doesn't exist - should return null
				actual = infoProcessor1.getNextStringStartsWith("goodbye");
				assertEquals(null, actual);
				
				// TODO write at least 2 additional test cases using different InfoProcessors
				// Recommended: Another basic functionality test that returns the next string in the list
				// Recommended: A test for a string that doesn't exist and returns null
				
				String actual2 = infoProcessor2.getNextStringStartsWith("Course");
				assertEquals(actual2,"CIT590");
	}

}
