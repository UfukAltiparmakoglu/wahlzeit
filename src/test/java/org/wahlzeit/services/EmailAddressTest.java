/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import junit.framework.TestCase;
import javax.mail.internet.InternetAddress;
import org.junit.Test;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	public EmailAddressTest(String name) {
		super(name);
	}

	@Test
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	@Test
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	@Test
	public void testEmptyEmailAddress() {
		EmailAddress mail = new EmailAddress("");
		assertFalse(mail.isEmpty());

		assertFalse(EmailAddress.EMPTY.isValid());
	}

	@Test
	public void testIsValid(){
		EmailAddress mail1 = new EmailAddress("");
		EmailAddress mail2 = new EmailAddress("myAddress@myprovider.com");

		assertTrue(mail1.isValid()); //valid locally. rejected by google
		assertTrue(mail2.isValid());
	}

	@Test
	public void testIsEqual(){
		String myAddress = "hello@aol.com";
		EmailAddress mail1 = new EmailAddress(myAddress);
		EmailAddress mail2 = new EmailAddress(myAddress);
		EmailAddress mail3 = new EmailAddress("foo" + myAddress);

		assertTrue(mail1.isEqual(mail1));
		assertFalse(mail1.isEqual(mail2));
		assertFalse(mail1.isEqual(mail3));
	}

	@Test
	public void testAsString(){
		String myAddress = "hello@aol.com";
		EmailAddress mail1 = new EmailAddress(myAddress);
		EmailAddress mail2 = new EmailAddress("");

		assertTrue(mail1.asString() == myAddress);
		assertTrue(mail2.asString() == "");
	}

	@Test
	public void testAsInternetAddress(){
		String myAddress = "hello@aol.com";
		EmailAddress mail1 = new EmailAddress(myAddress);
		InternetAddress internetAddress;

		try{
			internetAddress = new InternetAddress(myAddress);
			assertTrue(internetAddress.equals(mail1.asInternetAddress()));
		} catch (Exception e){
			//should not happen
		}
	}

}
