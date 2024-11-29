package br.bucker.bits.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.bucker.bits.data.vo.v1.PersonVO;
import br.bucker.bits.mapper.DozerMapper;
import br.bucker.bits.model.Person;
import br.bucker.bits.unittests.mapper.mocks.MockPerson;

public class DozerConvertTest {

    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
        
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Aplicação 0", output.getFirstName());
        assertEquals("Cursando Teste 0", output.getLastName());
        assertEquals("Rua Teste, 0 - Curitiba, PR", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Aplicação 0", outputZero.getFirstName());
        assertEquals("Cursando Teste 0", outputZero.getLastName());
        assertEquals("Rua Teste, 0 - Curitiba, PR", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        PersonVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Aplicação 7", outputSeven.getFirstName());
        assertEquals("Cursando Teste 7", outputSeven.getLastName());
        assertEquals("Rua Teste, 7 - Curitiba, PR", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        PersonVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Aplicação 12", outputTwelve.getFirstName());
        assertEquals("Cursando Teste 12", outputTwelve.getLastName());
        assertEquals("Rua Teste, 12 - Curitiba, PR", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Aplicação 0", output.getFirstName());
        assertEquals("Cursando Teste 0", output.getLastName());
        assertEquals("Rua Teste, 0 - Curitiba, PR", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Aplicação 0", outputZero.getFirstName());
        assertEquals("Cursando Teste 0", outputZero.getLastName());
        assertEquals("Rua Teste, 0 - Curitiba, PR", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Aplicação 7", outputSeven.getFirstName());
        assertEquals("Cursando Teste 7", outputSeven.getLastName());
        assertEquals("Rua Teste, 7 - Curitiba, PR", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Aplicação 12", outputTwelve.getFirstName());
        assertEquals("Cursando Teste 12", outputTwelve.getLastName());
        assertEquals("Rua Teste, 12 - Curitiba, PR", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }
}
