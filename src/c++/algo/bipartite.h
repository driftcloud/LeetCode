#pragma once

#include <vector>
#include <unordered_map>
#include <queue>

struct GraphNode {
    char ch;
    std::vector<GraphNode*> neighbors; 
};



bool BFS(GraphNode* node,  std::unordered_map<GraphNode*, int>& visisted) {
    int cur_color = 0;
    std::queue<GraphNode*> frontier;
    visisted[node] = cur_color;
    frontier.push(node);
    
    int curr_color = 0;
    
    while (!frontier.empty()) {
        auto cur_node = frontier.front();
        frontier.pop();
        curr_color = visisted[cur_node];
        for (auto neighbor : cur_node->neighbors) {
            if (visisted.count(neighbor) == 0) {
                visisted[neighbor] = 1 - curr_color;
                frontier.push(neighbor);
            } else if (visisted[neighbor] == curr_color) {
                return false;
            }
        }
    }
    return true;
}

bool IsBipartite(GraphNode* node) {
    //Graph color 0, or 1
    std::unordered_map<GraphNode*, int> visited_map;
    if (node == nullptr) return false;
    
    //visited_map[node] = 0;
    return BFS(node, visited_map);
}