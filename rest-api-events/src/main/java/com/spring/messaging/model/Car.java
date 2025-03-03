package com.spring.messaging.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends Persistence implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer code;
	private String model;
	private String hp;

	/* should use fetch = FetchType.LAZY for performance reasons, this case is for simplicity */
	@ManyToOne
	private User user;

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return Objects.equals(code, car.code) && Objects.equals(model, car.model) && Objects.equals(hp, car.hp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, model, hp);
	}

	@Override
	public String toString() {
		return "Car{" +
				"code=" + code +
				", model='" + model + '\'' +
				", hp='" + hp + '\'' +
				'}';
	}
}

