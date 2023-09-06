package com.payetonkawa.payetonkawa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class PayetonkawaApplicationTest {

	@Test
	void main() {
		assertDoesNotThrow(() -> PayetonkawaApplication.main(new String[]{}));
	}
}
