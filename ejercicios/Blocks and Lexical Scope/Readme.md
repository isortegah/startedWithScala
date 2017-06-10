Functional programming is designed to split up tasks into many small functions. Yet some of these functions should not be exposed to the developers using the function.
It is possible to avoid 'namespace pollution' by nesting the functions inside sqrt.
Blocks and Scope
The definitions inside blocks are only visible  from within the block.
The definitions inside a block shadow or cover up the definitions of the same name outside the block.
Question: What is the value of result in the following program?
    val x = 0
    def f(y: int) = y + 1
    val result  = {
        val x = f(3)
        x * x
    } + x

Answer :  16 
Explanation: Outside the block x = 0, however due to the nature of shadowing, inside the block x = f(3) = 3 + 1 = 4 therefore result = 4 * 4 + 0 = 16 + 0 = 16.
Lexical Scoping: The basis for how definitions are considered via the syntactic grammar.
The lexical scope in Scala provides that the definitions of outer blocks ARE visible inside a block unless they are shadowed.

Semicolons
In Scala semicolons are used to designate the end of an expression. However Scala provides the means to write most expressions without a semicolon. The exception is when multiple expressions are terminated on the same line.
Infix operators (operators of the type a + b) which occupy the center of their respective operands have issues with the semicolon deferral.  The traditional syntax of writing the infix operator on the following line:
        anExpression
    + anotherExpression
Would be evaluated as two separate expressions instead of the conjoining of a single expression. As a result: Parentheses should be used or the infix operator should be placed on the former line.
        (anExpression                            anExpression +
    + anotherExpression)                    anotherExpression

An important thing to take away from the this week is the substitution model as a way of reasoning about programming.