package nhu.novahub.assignment4.entities;


import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "Role")
public class Role implements Serializable{
  private static final long serialVersionUID = -3009157732242241606L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  
  private String name;

  public Role(Role role) {
    this.id = role.getId();
    this.name = role.getName();
  }
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return String.format("Customer[id=%d, name='%s']", id, name);
  }
  
}
