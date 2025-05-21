package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {
    
    // Q1 Addition Tests
    @Test
    public void testTrueAdd() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
    }
    
    @Test
    public void testAddNegativeNumbers() {
        Assert.assertEquals(-5.0, MathQuestionService.q1Addition("-2", "-3"), 0);
    }
    
    @Test
    public void testAddDecimalNumbers() {
        Assert.assertEquals(3.5, MathQuestionService.q1Addition("1.5", "2"), 0);
    }
    
    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }
    
    @Test
    public void testAddNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("1", ""));
    }
    
    @Test
    public void testAddBothEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }
    
    @Test
    public void testAddInvalidInput() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
    }
    
    // Q2 Subtraction Tests
    @Test
    public void testTrueSubtract() {
        Assert.assertEquals(5.0, MathQuestionService.q2Subtraction("8", "3"), 0);
    }
    
    @Test
    public void testSubtractNegativeResult() {
        Assert.assertEquals(-2.0, MathQuestionService.q2Subtraction("3", "5"), 0);
    }
    
    @Test
    public void testSubtractDecimalNumbers() {
        Assert.assertEquals(0.5, MathQuestionService.q2Subtraction("3.5", "3"), 0);
    }
    
    @Test
    public void testSubtractNumber1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
    }
    
    @Test
    public void testSubtractNumber2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("1", ""));
    }
    
    @Test
    public void testSubtractInvalidInput() {
        Assert.assertNull(MathQuestionService.q2Subtraction("5", "xyz"));
    }
    
    // Q3 Multiplication Tests
    @Test
    public void testTrueMultiply() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0);
    }
    
    @Test
    public void testMultiplyZero() {
        Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("0", "5"), 0);
    }
    
    @Test
    public void testMultiplyNegativeNumbers() {
        Assert.assertEquals(-10.0, MathQuestionService.q3Multiplication("5", "-2"), 0);
        Assert.assertEquals(15.0, MathQuestionService.q3Multiplication("-5", "-3"), 0);
    }
    
    @Test
    public void testMultiplyDecimalNumbers() {
        Assert.assertEquals(7.5, MathQuestionService.q3Multiplication("2.5", "3"), 0);
    }
    
    @Test
    public void testMultiplyNumber1Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "3"));
    }
    
    @Test
    public void testMultiplyNumber2Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("2", ""));
    }
    
    @Test
    public void testMultiplyInvalidInput() {
        Assert.assertNull(MathQuestionService.q3Multiplication("abc", "3"));
    }
}