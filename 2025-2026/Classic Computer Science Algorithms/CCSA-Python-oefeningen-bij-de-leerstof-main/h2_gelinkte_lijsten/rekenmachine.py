operators = {"+": 1, "-": 1, "*": 2,"/": 2, "(": 0}

class Stack:

    class Node():
        def __init__(self, data=None, next=None):
            self.data = data
            self.next = next
        
        def __str__(self):
            return str(self.data)

    def __init__(self):
        self.top = None
    
    def __str__(self):
        str = ""
        curr_node = self.top
        while curr_node != None:
            str += f" {curr_node}"
            curr_node = curr_node.next
        return str
    
    def is_empty(self):
        return self.top == None
    
    def push(self, data):
        self.top = self.Node(data, self.top)
    
    def pop(self):
        data = self.top.data
        self.top = self.top.next
        return data
    
    def peek(self):
        return self.top.data

def evalueer_postfix(expressie):
    stack = Stack()
    for token in expressie:
        if token not in operators.keys():
            stack.push(float(token))
            continue
        
        operand2 = stack.pop()
        operand1 = stack.pop()

        match token:
            case "+": stack.push(operand1 + operand2)
            case "-": stack.push(operand1 - operand2)
            case "*": stack.push(operand1 * operand2)
            case "/": stack.push(operand1 / operand2)
    return stack.pop()


def infix_naar_postfix(expressie):
    postfix = []
    operator_stack = Stack()
    for i in expressie:
        if i == ")":
            while (operator_stack.peek() != "("):
                postfix.append(operator_stack.pop())
            operator_stack.pop()
            continue

        if i not in operators:
            postfix.append(i)
            continue
        
        handle_operator(operator_stack, i, postfix)
        
    
    while(not operator_stack.is_empty()):
        postfix.append(operator_stack.pop())
    
    return postfix

def handle_operator(stack, operator, uitvoer):
    if stack.is_empty() or operators[operator] > operators[stack.peek()] or operator == "(":
        stack.push(operator)
        return
    
    while not stack.is_empty() and operators[stack.peek()] >= operators[operator]:
        uitvoer.append(stack.pop())
    stack.push(operator)
        

def rekenmachine(s):
    infix_tokens = s.split()
    postfix_tokens = infix_naar_postfix(infix_tokens)
    return evalueer_postfix(postfix_tokens)
