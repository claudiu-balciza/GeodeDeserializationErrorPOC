package org.deserializationError.domain;

import org.apache.geode.DataSerializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

@Region("DeserializationErrorPOC")
public class Class1 implements DataSerializable {
  @Id
  Integer id;
  String value;
  Timestamp lastUpdated;

  public Class1(Integer id, String value, Timestamp lastUpdated) {
    this.id = id;
    this.value = value;
    this.lastUpdated = lastUpdated;
  }

  public Class1(Integer id, String value) {
    this.id = id;
    this.value = value;
    this.lastUpdated = new Timestamp(Calendar.getInstance().getTime().getTime());
  }

  @Override
  public String toString() {
    return "Class1{" +
        "id=" + id +
        ", value='" + value + '\'' +
        ", lastUpdated=" + lastUpdated +
        '}';
  }

  public void toData(DataOutput out) throws IOException {
    out.writeUTF(id.toString());
    out.writeUTF(value);
    out.writeUTF(lastUpdated.toString());
  }

  public void fromData(DataInput inp) throws IOException {
    id = Integer.parseInt(inp.readUTF());
    value = inp.readUTF();
    lastUpdated = Timestamp.valueOf(inp.readUTF());
  }
}
