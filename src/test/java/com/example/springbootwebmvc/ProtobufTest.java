package com.example.springbootwebmvc;

import com.example.springbootwebmvc.protobuf.ExampleProtos.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProtobufTest {
    @Test
    public void testProtobufSerialization() throws Exception {
        // 创建一个Person对象
        Person person = Person.newBuilder()
                .setId(1234)
                .setName("John Doe")
                .setEmail("jdoe@example.com")
                .build();

        // 序列化123123
        byte[] serialized = person.toByteArray();
        assertNotNull(serialized);
        assertTrue(serialized.length > 0);

        // 反序列化
        Person deserialized = Person.parseFrom(serialized);
        assertEquals(person.getId(), deserialized.getId());
        assertEquals(person.getName(), deserialized.getName());
        assertEquals(person.getEmail(), deserialized.getEmail());
    }
} 