package com.actionict.customer;

import com.actionict.customer.entity.Country;
import com.actionict.customer.repository.CountryRepository;
import com.actionict.customer.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mock objects
    }

    @Test
    void testFindAll() {
        // Arrange
        Country country1 = new Country();
        country1.setName("USA");
        Country country2 = new Country();
        country2.setName("Canada");

        List<Country> countries = Arrays.asList(country1, country2);

        when(countryRepository.findAll()).thenReturn(countries); // Mock repository call

        // Act
        List<Country> result = countryService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("USA", result.get(0).getName());
        assertEquals("Canada", result.get(1).getName());

        verify(countryRepository, times(1)).findAll(); // Verify that findAll was called once
    }
}
