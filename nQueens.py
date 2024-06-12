# # nqueens problem in python with comments

# # This function checks if a queen can be placed on board[row][col].
# # Note that this function is called when "col" queens are already placed
# # in columns from 0 to col -1. So we need to check only left side for
# # attacking queens
# def isSafe(board, row, col, n):
#     # Check this row on left side
#     for i in range(col):
#         if board[row][i] == 1:
#             return False

#     # Check upper diagonal on left side
#     for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
#         if board[i][j] == 1:
#             return False

#     # Check lower diagonal on left side
#     for i, j in zip(range(row, n, 1), range(col, -1, -1)):
#         if board[i][j] == 1:
#             return False

#     return True
# def solveNQueensUtil(board, col, n, res):
#     # base case: If all queens are placed then return true
#     if col >= n:
#         v = []
#         for i in range(n):
#             for j in range(n):
#                 if board[i][j] == 1:
#                     v.append(j+1)
#         res.append(v)
#         return True

#     # Consider this column and try placing this queen in all rows one by one
#     for i in range(n):

#         if isSafe(board, i, col, n):
#             # Place this queen in board[i][col]
#             board[i][col] = 1

#             # recur to place rest of the queens
#             solveNQueensUtil(board, col + 1, n, res)

#             # If placing queen in board[i][col] doesn't lead to a solution,
#             # then remove queen from board[i][col]
#             board[i][col] = 0

#     # if the queen can not be placed in any row in this colum col then return false
#     return False
# def solveNQueens(n):
#     board = [[0 for i in range(n)] for j in range(n)]
#     res = []
#     solveNQueensUtil(board, 0, n, res)
#     return res
# # main
# n = 5
# res = solveNQueens(n)
# print(res)

def isSafe(r, c, n, board):

    row = r
    col = c

    while(r >= 0 and c >=0):
        if board[r][c] == 1:
            return False
        r-=1
        c-=1

    r = row
    c = col

    while(c >=0):
        if board[r][c] == 1:
            return False
        c-=1
    
    c = col

    while(r < n and c >= 0):
        if board[r][c] == 1:
            return False
        r+=1    
        c-=1
    
    return True

def solveNQueen(col, n, board, res):

    if col == n:
        res.append(board)
        print(res)
        return res
    
    for row in range(n):
        if isSafe(row, col, n, board):
            print(board[row])
            board[row][col] = 1
            solveNQueen(col+1, n, board, res)
            board[row][col] = 0




def printSolution(n):
    res = []
    board = [[0 for j in range(n)] for i in range(n)];
    # print(board)
    solveNQueen(0, n, board, res)
    return res
    
ans = printSolution(8)
print("Yes")
print(ans)