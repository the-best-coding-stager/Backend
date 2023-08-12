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

}
