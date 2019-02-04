package com.coresystems.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-31T12:00:14.359+0200")
@StaticMetamodel(Module.class)
public class Module_ {
	public static volatile SingularAttribute<Module, Integer> id;
	public static volatile SingularAttribute<Module, String> name;
	public static volatile ListAttribute<Module, Student> students;
}
