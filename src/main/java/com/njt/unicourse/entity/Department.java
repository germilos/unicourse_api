package com.njt.unicourse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "department")
public class Department {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;

		@Column(name = "name")
		private String name;

		public Department() {

		}

		public Department(final int id, final String name) {
				super();
				this.id = id;
				this.name = name;
		}

		public int getId() {
				return id;
		}

		public void setId(final int id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(final String name) {
				this.name = name;
		}

		@Override
		public String toString() {
				return "Department [id=" + id + ", name=" + name + "]";
		}
}
