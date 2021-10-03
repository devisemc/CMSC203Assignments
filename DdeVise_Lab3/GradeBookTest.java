import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	//Declare GradeBook vars
	private GradeBook book1;
	private GradeBook book2;
	@BeforeEach
	void setUp() throws Exception {
		//Set to instances of GradeBook
	    book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		
		//Add book1 scores
		book1.addScore(23);
		book1.addScore(24);
		book1.addScore(8);
		
		//Add book2 scores
		book2.addScore(25);
		book2.addScore(1300);
		book2.addScore(1804);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(book1.toString().equals("23.0 24.0 8.0"));
		assertTrue(book2.toString().equals("25.0 1300.0 1804.0"));
		assertEquals(book1.getScoreSize(), 3);
		assertEquals(book2.getScoreSize(), 3);
	}

	@Test
	void testSum() {
		assertEquals(book1.sum(), 55);
		assertEquals(book2.sum(), 3129);
	}

	@Test
	void testMinimum() {
		assertEquals(book1.minimum(), 8);
		assertEquals(book2.minimum(), 25);
	}

	@Test
	void testFinalScore() {
		assertEquals(book1.finalScore(), 47);
		assertEquals(book2.finalScore(), 3104);
	}

	@Test
	void testGetScoreSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
