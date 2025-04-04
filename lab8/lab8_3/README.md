I don't have access to my IES project.

I am analyzing WordPress-Android.
It contains a blocker level issue on reliability, that consists of a double-checked locking. This is the practice of checking a lazy-initialized object's state both before and after a synchronized block is entered, to determine whether to initialize the object. To solve it, simply use synchronized methods, which in recent JVM versions are preferred, and if that's not possible, consider using an inner static class to hold the reference instead.
There's also security issues: some exported components do not have permissions set up. It would be very simple to fix this, just by adding the line that sets the right permissions to the given component.
