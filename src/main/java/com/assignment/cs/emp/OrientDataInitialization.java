package com.assignment.cs.emp;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.repository.annotation.Vertex;

import com.assignment.cs.emp.util.EmpUtil;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientVertexType;

/**
 * 
 * @author sanjib.pramanick
 *
 */
//@Configuration
public class OrientDataInitialization {

	@Autowired
	private OrientGraph orientGraph;

	@PostConstruct
	public void initialize() {
		try {
			Class<?>[] classes = EmpUtil.getClasses("com.assignment.cs.emp.bean");

			System.err.println("Class:" + Arrays.asList(classes));

			for (Class<?> clazz : classes) {
				if (clazz.getAnnotation(Vertex.class) != null) {
					Class<?> superclass = clazz.getSuperclass();
					OrientVertexType vertexType;
					if (superclass == Object.class) {
						vertexType = orientGraph.createVertexType(clazz.getSimpleName());

					} else {
						vertexType = orientGraph.createVertexType(clazz.getSimpleName(), superclass.getSimpleName());
					}
					populateProperties(clazz, vertexType);
				}

			}
			orientGraph.commit();
		} catch (Exception e) {
			e.printStackTrace();
			orientGraph.rollback();
		}
	}

	private void populateProperties(Class<?> clazz, OrientVertexType vertexType) {
		Field[] declaredMethods = clazz.getDeclaredFields();
		Arrays.stream(declaredMethods).forEach(field -> {
			vertexType.createProperty(field.getName(), OType.ANY);
		});
	}

}
