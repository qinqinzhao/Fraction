<h4><strong>General idea: </strong></h4>

<li>Implement a Fraction API. </li>
<li>Write very thorough JUnit tests. </li>
<li>Write a small "calculator" program to do arithmetic with fractions. </li>

<h4><strong>The API</strong></h4>

Java provides several types of numbers, but it does not provide fractions. The task is to implement a Fraction API and write a small program that uses it.

The following is some information about the new Fraction type.

<li><strong>Instance variables</strong>: Two private integers, known as the numerator and the denominator. Do not provide getters or setters for these instance variables; there is no reason for anything outside the Fraction class to know about them.</li>
<li><strong>How written</strong>: n/d, where n is the numerator and d is the denominator.</li>
<li><strong>Restrictions</strong>: The denominator may not be zero. </li>
<li><strong>Normalization</strong>:	
 <ul>
 <li>The fraction is always kept in the lowest terms, that is, the Greatest Common Divisor (GCD) of n and d is 1 (use Euclid's algorithm). </li>
 <li>The denominator is never negative. (You can give a negative number for the denominator to the constructor when you create the fraction, but a negative fraction should be represented internally with a negative numerator.) </li>
 <li>Zero should be represented as 0/1. </li>
 </ul>
</li>

<h4><strong>The FractionCalculator</strong></h4>

The FractionCalculator does calculations with Fractions. The first thing this program does is print a zero (indicating the current contents of the calculator), and a prompt. It then accepts commands from the user, and after each command, prints the result, and a new prompt. It should accept exactly the following commands, and nothing else:

<li><b>a</b>  To take the absolute value of the number currently displayed.</li>
<li><b>c</b>  To clear (reset to zero) the calculator.</li>
<li><b>i</b>  To invert the number currently displayed.</li>
<li><b>s</b> <i>n</i>  To discard the number currently displayed and replace it with n.</li>
<li><b>q</b>  To quit the program.</li>
<li><b>+</b> <i>n</i>  To add n to the number currently displayed.</li>
<li><b>-</b> <i>n</i>  To subtract n from the number currently displayed.</li>
<li><b>*</b> <i>n</i>  To multiply the number currently displayed by n.</li>
<li><b>/</b> <i>n</i>  To divide the number currently displayed by n.</li>

In each case, the user may enter either a whole number or a fraction for n.

<li>Fractions may be written with or without spaces, as for example 27 / 99 or 27/99.</li>
<li>You can require that there be no space after a unary minus, so for example -3 is legal, but - 3 is not.</li>
<li>You don't have to handle unary +.</li>
<li>You can require at least one space after the initial +, -, *, /, or s, so for example - -3/5 is legal, but --3/5 is not.</li>

No user input, however illegal, should crash the program. Instead, the program should print a short error message. Illegal input should not affect the state of the computation.
