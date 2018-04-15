package nhu.novahub.assignment4.entities;



import javax.persistence.*;


@Entity
@Table (name = "Role")
public class Role{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  
  private String name;
  
  public Role() {
  }
  
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
