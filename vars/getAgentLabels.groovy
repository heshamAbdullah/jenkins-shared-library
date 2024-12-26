import jenkins.model.Jenkins

def call() {
    def labels = []
    Jenkins.get().getNodes().each { node ->
        labels.add(node.getLabelString())
    }
    labels = labels.findAll { it?.trim() }.unique() // Remove empty and duplicate labels
    
    if (labels.isEmpty()) {
        labels.add('No nodes available') // Fallback if no nodes have labels
    }
    
    return labels
}