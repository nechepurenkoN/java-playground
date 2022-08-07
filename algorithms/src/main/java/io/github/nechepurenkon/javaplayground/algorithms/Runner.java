package io.github.nechepurenkon.javaplayground.algorithms;

import io.github.nechepurenkon.javaplayground.algorithms.interval.SegmentTree;

public class Runner {
    public static void main(String[] args) {
        final var segmentTree = new SegmentTree(new int[]{1,3,4,3,2,5,6,1,5,6});
        segmentTree.update(0, 2);
        System.out.println(segmentTree.sumRange(0, 9));
    }
}
