package com.coursera.algo1.week4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solver {
    private final MinPQ<SearchNode> gamePQ, alternateGamePQ;
    private boolean isSolvable;
    private int moves;
    private List<SearchNode> solutionList;
    private List<Board> finalSolutionList;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial){
        if(initial==null){
            throw new IllegalArgumentException();
        }
        gamePQ = new MinPQ<>(new SearchNodeComparator());
        SearchNode initialNode=new SearchNode(initial, 0, null);
        gamePQ.insert(initialNode);

        alternateGamePQ = new MinPQ<>(new SearchNodeComparator());
        alternateGamePQ.insert(new SearchNode(initial.twin(), 0, null));

        solutionList=new ArrayList<>();
        solvePuzzle();
//        Collections.sort(solutionList, new SearchNodeSolutionTreeComparator());
        finalSolutionList=new ArrayList<>();
        solutionList.forEach(searchNode -> {
            if(searchNode.movesCount <= moves)
                finalSolutionList.add(searchNode.board);
        });
        solutionList=null;

/*        if(solutionMap != null)
            solutionMap.forEach((key, board)->{
            if(key <= moves)
                solutionList.add(board);
            });*/

//        gamePQ=null;
//        alternateGamePQ=null;
    }

    private void solvePuzzle(){
        while(!gamePQ.min().board.isGoal()  && !alternateGamePQ.min().board.isGoal()){
            SearchNode currentNode = gamePQ.delMin();
            moves = currentNode.movesCount +1;
//            solutionList.add(currentNode.board);
//            solutionMap.put(moves,currentNode.board);
            if(solutionList.contains(currentNode)){
                solutionList.remove(currentNode);
            }
            solutionList.add(currentNode);
            currentNode.board.neighbors().forEach(neighbour-> {
                if(currentNode.previousSearchNode==null || !neighbour.equals(currentNode.previousSearchNode.board)) {
                    SearchNode neighbourNode = new SearchNode(neighbour, moves, currentNode);
                    gamePQ.insert(neighbourNode);
                }
            });

            SearchNode currentAlternateNode = alternateGamePQ.delMin();
            currentAlternateNode.board.neighbors().forEach(neighbour-> {
                if(currentAlternateNode.previousSearchNode==null || !neighbour.equals(currentAlternateNode.previousSearchNode.board)) {
                    SearchNode neighbourNode = new SearchNode(neighbour, moves, currentAlternateNode);
                    alternateGamePQ.insert(neighbourNode);
                }
            });
        }
        if(alternateGamePQ.min().board.isGoal()){
            moves=-1;
            isSolvable = false;

        }else{
            isSolvable = true;
//            solutionList.add(gamePQ.min().board);
            moves = gamePQ.min().movesCount;
//            solutionMap.put(moves, gamePQ.min().board);
//            solutionPQ.insert(gamePQ.min());
            solutionList.add(gamePQ.min());
        }
    }
    // is the initial board solvable? (see below)
    public boolean isSolvable(){
        return this.isSolvable;
    }

    // min number of moves to solve initial board
    public int moves(){
        return this.moves;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
        if(isSolvable){
            return finalSolutionList;
        }else{
//            return new ArrayList<>();
            return null;
        }
    }

    private class SearchNode{
        Board board;
        int movesCount;
        SearchNode previousSearchNode;


        public SearchNode(Board board, int movesCount, SearchNode previousSearchNode) {
            this.board = board;
            this.movesCount = movesCount;
            this.previousSearchNode = previousSearchNode;
        }


        @Override
        public boolean equals(Object obj) {
            SearchNode that = (SearchNode) obj;
            return this.movesCount==that.movesCount;
        }
    }

    private class SearchNodeComparator implements Comparator<SearchNode>{

        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            return (o1.movesCount + o1.board.manhattan()) - (o2.movesCount+o2.board.manhattan());
        }
    }

    private class SearchNodeSolutionTreeComparator implements Comparator<SearchNode>{
        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            return (o1.movesCount) - (o2.movesCount);
        }
    }


/*    // test client (see below)
    public static void main(String[] args){
        int i=0;
    }*/

}
