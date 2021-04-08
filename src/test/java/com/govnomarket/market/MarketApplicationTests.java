package com.govnomarket.market;

import com.govnomarket.market.dto.PersonDTO;
import com.govnomarket.market.entity.Person;
import com.govnomarket.market.passwordhashing.SHA512Hasher;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Disabled
class MarketApplicationTests {

	private SHA512Hasher hasher;
	private SecureRandom secureRandom;

	@Test
	void contextLoads() {
	}

	@Test
	public void whenConvertPersonEntityToPersonDto_thenCorrect() {

		hasher = new SHA512Hasher();
		secureRandom = new SecureRandom();

		byte[] salt = new byte[16];
		secureRandom.nextBytes(salt);

		String hash1 = hasher.hash("password", salt);
		
		Person person = new Person();
		person.setId(1L);
		person.setName("Иван");
		person.setFullname("Иван Иванович Иванов");
		person.setRole("client");
		person.setEmail("ivan@email.com");
		person.setPasswordHash(hash1);
		person.setLogin("ivan");


		PersonDTO personDto = PersonDTO.personToPersonDto(person);

		assertEquals(personDto.getId() ,person.getId());
		assertEquals(personDto.getName() ,person.getName());
		assertEquals(personDto.getFullname() ,person.getFullname());
		assertEquals(personDto.getRole() ,person.getRole());
		assertEquals(personDto.getEmail() ,person.getEmail());
		assertEquals(personDto.getPasswordHash() ,person.getPasswordHash());
		assertEquals(personDto.getLogin() ,person.getLogin());

	}

	@Test
	public void whenConvertPersonDtoToPersonEntity_thenCorrect() {

		hasher = new SHA512Hasher();
		secureRandom = new SecureRandom();

		byte[] salt = new byte[16];
		secureRandom.nextBytes(salt);

		String hash1 = hasher.hash("password", salt);

		PersonDTO personDto = new PersonDTO();
		personDto.setId(1L);
		personDto.setName("Иван");
		personDto.setFullname("Иван Иванович Иванов");
		personDto.setRole("client");
		personDto.setEmail("ivan@email.com");
		personDto.setPasswordHash(hash1);
		personDto.setLogin("ivan");

		Person person = PersonDTO.personDtoToPerson(personDto);

		assertEquals(personDto.getId() ,person.getId());
		assertEquals(personDto.getName() ,person.getName());
		assertEquals(personDto.getFullname() ,person.getFullname());
		assertEquals(personDto.getRole() ,person.getRole());
		assertEquals(personDto.getEmail() ,person.getEmail());
		assertEquals(personDto.getPasswordHash() ,person.getPasswordHash());
		assertEquals(personDto.getLogin() ,person.getLogin());
	}

}
