extends Node2D

# Calls the grass gut effect
onready var animatedSprite = $ AnimatedSprite

# The _ready() function is called when the node, and all its children, enters 
# the active scene. - Not a constructor

# when active, it plays the grass effect
func _ready():
	animatedSprite.frame = 0;
	
	# Play plays the animation thats being refered to in this case Animate
	animatedSprite.play("Animate")

func _on_AnimatedSprite_animation_finished():
	# Frees a node and it's children - visually deletes them
	queue_free()
