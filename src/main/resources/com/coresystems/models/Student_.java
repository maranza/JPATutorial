package com.coresystems.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-31T12:00:14.483+0200")
@StaticMetamodel(Student.class)
public class Student_ {
	public static volatile SingularAttribute<Student, Integer> id;
	public static volatile SingularAttribute<Student, String> firstName;
	public static volatile SingularAttribute<Student, String> lastName;
	public static volatile ListAttribute<Student, Module> modules;
}
