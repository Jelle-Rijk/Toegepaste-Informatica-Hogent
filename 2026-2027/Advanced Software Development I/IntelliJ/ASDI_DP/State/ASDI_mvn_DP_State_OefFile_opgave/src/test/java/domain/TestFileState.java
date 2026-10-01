package domain;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestFileState {

    private FileEditor file;

    @BeforeEach
    void setUp() {
        file = new FileEditor(new File("opgave"));
    }

    @Test
    void testInitState() {
        assertFalse(file.save());
    }

    @Test
    void testNaarCleanState() {

        file.edit();

        //Van dirty naar clean
        assertTrue(file.save());

        assertFalse(file.save());
    }

    @Test
    void testNaarDirtyState() {
        //Van clean naar dirty
    	assertTrue(file.edit());

    	assertFalse(file.edit());

        file.save();

        //Van clean naar dirty
        assertTrue(file.edit());
    }
}