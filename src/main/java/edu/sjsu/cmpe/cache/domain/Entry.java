package edu.sjsu.cmpe.cache.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

public class Entry {

    @NotNull
    private int key;

    @NotEmpty
    private CharSequence value;

    @NotEmpty
    private DateTime createdAt = new DateTime();

    /**
     * @return the key
     */
    public int getKey() {
	return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(int key) {
	this.key = key;
    }

    /**
     * @return the value
     */
    public CharSequence getValue() {
	return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(CharSequence value) {
	this.value = value;
    }

    /**
     * @return the createdAt
     */
    public DateTime getCreatedAt() {
	return createdAt;
    }

    /**
     * @param createdAt
     *            the createdAt to set
     */
    public void setCreatedAt(DateTime createdAt) {
	this.createdAt = createdAt;
    }
}
