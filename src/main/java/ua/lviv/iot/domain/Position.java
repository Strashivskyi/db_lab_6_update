package ua.lviv.iot.domain;
import javax.persistence.*;
import java.util.Set;

@Table(name = "position")
@Entity
public class Position {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @OneToMany(mappedBy = "positionId", fetch = FetchType.EAGER)
  private Set<Employee> employees;

  public Position(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Position(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Position() {

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return "Position{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
