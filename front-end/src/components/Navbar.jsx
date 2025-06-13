const Navbar = () => {
  return (
    <nav className="bg-gray-900 shadow p-4 flex justify-between items-center">
      <h1 className="text-2xl font-bold text-green-500">ConnectForo</h1>
      <button className="bg-green-500 hover:bg-green-600 text-white px-4 py-1 rounded">
        Iniciar Sesión
      </button>
    </nav>
  );
};

export default Navbar;
