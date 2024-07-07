package app.delivery.api.adapters.contract.openapi.model;

import java.net.URI;
import java.util.Objects;
import app.delivery.api.adapters.contract.openapi.model.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Courier
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T20:55:22.906773+03:00[Europe/Kiev]")
public class Courier {

  private UUID id;

  private String name;

  private Location location;

  public Courier() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Courier(UUID id, String name, Location location) {
    this.id = id;
    this.name = name;
    this.location = location;
  }

  public Courier id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", description = "Идентификатор", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Courier name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Имя
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Имя", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Courier location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @NotNull @Valid 
  @Schema(name = "location", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("location")
  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Courier courier = (Courier) o;
    return Objects.equals(this.id, courier.id) &&
        Objects.equals(this.name, courier.name) &&
        Objects.equals(this.location, courier.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Courier {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

