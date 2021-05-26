extends AnimatedSprite

# The _ready() function is called when the node, and all its children, enters 
# the active scene. - Not a constructor

func _ready():
	# Self here verifies the sprite that it's checking

	# Objects can have a set of signals defined here, _ready() connects to
	# animation finished
	
	# Play plays the animation thats being refered to in this case Animate
	
	# warning-ignore:return_value_discarded
	connect("animation_finished", self, "_on_AnimatedSprite_animation_finished")
	frame = 0
	play("Animate")

# Once the animation is finished, the inheritors will be freed
func _on_AnimatedSprite_animation_finished():
	
	# Frees a node and it's children - visually deletes them
	queue_free()
