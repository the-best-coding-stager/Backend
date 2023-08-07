package com.example.demo.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Word")
@Entity
public class Word implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
    private String name;
	
	@Version
    private long version;
	
	public Word() {
        super();
    }
	
	public Word(final String name) {
        super();

        this.name = name;
    }
	
	// API
	public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
    
    //
}
